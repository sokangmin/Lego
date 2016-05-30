package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.PipeBlock;
import com.wini.lego.context.Context;

@ForEach
@Log4j2
public class Txt2EXPNDTR_E_DtoBlock extends PipeBlock<File, List<EXPNDTR_E_Dto>> {

	@Override
	protected List<EXPNDTR_E_Dto> doing(File data) {
		List<EXPNDTR_E_Dto> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		Context.set(data);
		
		try( FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);) {
			char [] buffer = new char[512];
			int readcount = 0;
			while((readcount = br.read(buffer)) != -1) {
				sb.append(buffer,0,readcount);
			}
			
		} catch (IOException e) {
			log.error(e);
		}
		
		String str = sb.toString();
		String[] array = str.split("(!@\\^#![$][$][$][$][$]\r\n)|(!@\\^#!GUBUN\r\n)");
		
		if(array.length > 1) {
			for (int i = 1; i < array.length; i++) {
				String s = array[i];
				String[] arr = s.split("!@\\^#!", 26);
				
				if(arr.length == 26) {
					try {
						EXPNDTR_E_Dto info = EXPNDTR_E_Dto.class.newInstance();
						
						Field[] fields = EXPNDTR_E_Dto.class.getDeclaredFields();
						for(int j=0; j<fields.length; j++) {
							fields[j].setAccessible(true);
							fields[j].set(info, arr[j]);
						}
						
						list.add(info);
						
					} catch (InstantiationException | IllegalAccessException e) {
						log.error(e);
					}
				}
			}
		}
		
		return list;
	}

}
