package com.bbs.web.controller;

import com.bbs.common.ConstForum;
import com.bbs.db.entity.BoardEntity;
import com.bbs.db.entity.TopicEntity;
import com.bbs.service.ForumService;
import com.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BoardManageController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(BoardManageController.class);

    @Resource
    private TopicService topicService;
    @Resource
    private ForumService forumService;

    @RequestMapping("/board/board-{boardId}")
    public String listTopics(@PathVariable Integer boardId, @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer pageSize, ModelMap model) {
        List<TopicEntity> topicList = topicService.listTopicByBoardId(boardId, pageNo, pageSize);
        BoardEntity board = forumService.findBoardById(boardId);
        model.addAttribute(ConstForum.TOPIC_PAGE_CXT, topicList);
        model.addAttribute(ConstForum.BOARD_CXT, board);
        logger.debug("获取主题列表");
        return "board/listBoardTopics";
    }
}
