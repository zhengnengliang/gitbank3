package com.bdqn.service.TradeEnds;

import java.util.List;

import com.bdqn.pojo.ItripTradeEnds;

public interface ItripTradeEndsService {
	int deleteByPrimaryKey(Long id);

	// int insert(ItripTradeEnds record);

	int insertSelective(ItripTradeEnds record);

	List<ItripTradeEnds> selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ItripTradeEnds record);

	// int updateByPrimaryKey(ItripTradeEnds record);
}
