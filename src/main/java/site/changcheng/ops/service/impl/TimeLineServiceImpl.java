package site.changcheng.ops.service.impl;

import javafx.animation.Timeline;
import org.springframework.stereotype.Service;
import site.changcheng.ops.entity.TimeLine;
import site.changcheng.ops.mapper.TimeLineMapper;
import site.changcheng.ops.service.TimeLineService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baiju on 2017/6/4.
 */
@Service("timeLineService")
public class TimeLineServiceImpl implements TimeLineService
{
    @Resource
    private TimeLineMapper mapper;
    @Override
    public List<TimeLine> getAllTimeLines() {
        return mapper.getAllTimeLines();
    }
}
