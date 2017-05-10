package com.bbs.service;

import com.bbs.common.ConstForum;
import com.bbs.db.dao.TopicEntityMapper;
import com.bbs.db.entity.TopicEntity;
import com.bbs.db.entity.TopicEntityExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicService {

    @Resource
    private TopicEntityMapper topicEntityMapper;

    public List<TopicEntity> listTopicByBoardId(int boardId, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo <= 0) pageNo = 1;
        if (pageSize == null || pageSize <= 0) pageSize = ConstForum.TOPIC_PAGE_SIZE;
        TopicEntityExample example = new TopicEntityExample();
        example.createCriteria().andBoardIdEqualTo(boardId);
        example.setOrderByClause("last_post desc");
        example.setLimitSize(pageSize);
        example.setLimitStart(pageSize * (pageNo - 1));
        return topicEntityMapper.selectByExample(example);
    }
}
