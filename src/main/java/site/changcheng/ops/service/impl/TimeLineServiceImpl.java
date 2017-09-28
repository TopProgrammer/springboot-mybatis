package site.changcheng.ops.service.impl;

import org.springframework.stereotype.Service;
import site.changcheng.ops.helper.TimeLine;
import site.changcheng.ops.service.TimeLineService;

import java.util.List;

/**
 * Created by changcheng on 2017/9/12.
 */
@Service("timeLineService")
public class TimeLineServiceImpl implements TimeLineService{
    @Override
    public List<TimeLine> getAllTimeLines() {
        return null;
    }
}
