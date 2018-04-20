package com.bdqn.service.TradeEnds;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.ItripTradeEnds.ItripTradeEndsMapper;
import com.bdqn.pojo.ItripTradeEnds;
@Service
public class ItripTradeEndsServiceImpl implements ItripTradeEndsService {

	@Resource
	private ItripTradeEndsMapper itripTradeEndsMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripTradeEnds = -1;
		try {
			deleteItripTradeEnds = itripTradeEndsMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripTradeEnds;
	}

	@Override
	public int insertSelective(ItripTradeEnds record) {
		int insertItripTradeEnds = -1;
		try {
			insertItripTradeEnds = itripTradeEndsMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripTradeEnds;
	}

	@Override
	public List<ItripTradeEnds> selectByPrimaryKey(String id) {
		List<ItripTradeEnds> selectItripTradeEnds = null;
		try {
			selectItripTradeEnds = itripTradeEndsMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripTradeEnds;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripTradeEnds record) {
		int updateItripTradeEnds = -1;
		try {
			updateItripTradeEnds = itripTradeEndsMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripTradeEnds;
	}

}
