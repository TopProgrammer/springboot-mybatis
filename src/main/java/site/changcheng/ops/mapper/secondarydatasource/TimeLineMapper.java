package site.changcheng.ops.mapper.secondarydatasource;

import org.apache.ibatis.annotations.Select;
import site.changcheng.ops.entity.TimeLine;

import java.util.List;

/**
 * Created by baiju on 2017/6/4.
 */
public interface TimeLineMapper {
    @Select("SELECT * FROM timeline")
    List<TimeLine> getAllTimeLines();
}
