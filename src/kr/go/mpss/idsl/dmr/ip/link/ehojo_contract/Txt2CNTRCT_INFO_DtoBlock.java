package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

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
public class Txt2CNTRCT_INFO_DtoBlock extends PipeBlock<File, List<CNTRCT_INFO_Dto>> {

	@Override
	protected List<CNTRCT_INFO_Dto> doing(File data) {
		List<CNTRCT_INFO_Dto> list = new ArrayList<>();
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
				String[] arr = s.split("!@\\^#!");
				
				if(arr.length == 34) {
					try {
						CNTRCT_INFO_Dto info = CNTRCT_INFO_Dto.class.newInstance();
						
						Field[] fields = CNTRCT_INFO_Dto.class.getDeclaredFields();
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
