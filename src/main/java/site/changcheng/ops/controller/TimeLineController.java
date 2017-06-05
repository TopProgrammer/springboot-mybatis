package site.changcheng.ops.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.changcheng.ops.entity.TimeLine;
import site.changcheng.ops.entity.User;
import site.changcheng.ops.service.ITimeLineService;
import site.changcheng.ops.service.UserService;
import site.changcheng.ops.utils.OperationResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动管理Banner图
 *
 * @author wangzhicheng@uworks.cc
 */
@Api(value = "时间轴 相关接口", produces = "application/json",description ="时间轴相关操作接口")
@RestController
@RequestMapping("/timeline")
public class TimeLineController {

    @Resource
    private ITimeLineService timeLineService;

    private Logger logger= LoggerFactory.getLogger("TimeLineController");

    /**
     * <pre>
     * 添加用户
     * 请求方式：POST
     * 请求路径：/user/addUser
     * 请求参数:user 实体
     * 返回参数：
     * </pre>
     * @return
     */
    @RequestMapping(value = "/getAllTimeLines", method = RequestMethod.GET)
    public String getAllTimeLines(){
        List<TimeLine> list = timeLineService.getAllTimeLines();
        return OperationResult.success(list);
    }

}
