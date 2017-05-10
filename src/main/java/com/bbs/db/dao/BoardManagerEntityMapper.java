package com.bbs.db.dao;

import com.bbs.db.entity.BoardManagerEntityExample;
import com.bbs.db.entity.BoardManagerEntityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardManagerEntityMapper {
    int countByExample(BoardManagerEntityExample example);

    int deleteByExample(BoardManagerEntityExample example);

    int deleteByPrimaryKey(BoardManagerEntityKey key);

    int insert(BoardManagerEntityKey record);

    int insertSelective(BoardManagerEntityKey record);

    List<BoardManagerEntityKey> selectByExample(BoardManagerEntityExample example);

    int updateByExampleSelective(@Param("record") BoardManagerEntityKey record, @Param("example") BoardManagerEntityExample example);

    int updateByExample(@Param("record") BoardManagerEntityKey record, @Param("example") BoardManagerEntityExample example);
}