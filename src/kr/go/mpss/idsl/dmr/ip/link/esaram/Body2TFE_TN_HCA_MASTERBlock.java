package kr.go.mpss.idsl.dmr.ip.link.esaram;

import java.util.ArrayList;
import java.util.List;

import kr.go.mpss.idsl.dmr.ip.link.esaram.Body.DataList;
import lombok.extern.log4j.Log4j2;

import org.modelmapper.ModelMapper;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class Body2TFE_TN_HCA_MASTERBlock  extends PipeBlock<Body, List<TFE_TN_HCA_MASTER>>{

	@Override
	protected List<TFE_TN_HCA_MASTER> doing(Body data) {
		List<TFE_TN_HCA_MASTER> list = new ArrayList<>();
		
		log.info("rowCount - " + data.getRowCount());
		if(data.getRowCount() > 0) {
			ModelMapper mapper = new ModelMapper();
			
			for(DataList data1:data.getDataList()) {
				TFE_TN_HCA_MASTER dao = mapper.map(data1, TFE_TN_HCA_MASTER.class);
				
				list.add(dao);
			}
			
			log.info("Convert Body to List<TFE_TN_HCA_MASTER> Object.");
		}
		
		return list;
	}

}
