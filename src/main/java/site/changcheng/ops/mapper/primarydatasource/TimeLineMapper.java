package site.changcheng.ops.mapper.primarydatasource;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import site.changcheng.ops.entity.TimeLine;
import site.changcheng.ops.entity.TimeLineExample;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public interface TimeLineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @SelectProvider(type=TimeLineSqlProvider.class, method="countByExample")
    int countByExample(TimeLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @DeleteProvider(type=TimeLineSqlProvider.class, method="deleteByExample")
    int deleteByExample(TimeLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @Delete({
        "delete from timeline",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @Insert({
        "insert into timeline (id, content, ",
        "title, year, createtime, ",
        "time, important)",
        "values (#{id,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{year,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{time,jdbcType=VARCHAR}, #{important,jdbcType=INTEGER})"
    })
    int insert(TimeLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @InsertProvider(type=TimeLineSqlProvider.class, method="insertSelective")
    int insertSelective(TimeLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @SelectProvider(type=TimeLineSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="important", property="important", jdbcType=JdbcType.INTEGER)
    })
    List<TimeLine> selectByExample(TimeLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @Select({
        "select",
        "id, content, title, year, createtime, time, important",
        "from timeline",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="important", property="important", jdbcType=JdbcType.INTEGER)
    })
    TimeLine selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @UpdateProvider(type=TimeLineSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TimeLine record, @Param("example") TimeLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @UpdateProvider(type=TimeLineSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TimeLine record, @Param("example") TimeLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @UpdateProvider(type=TimeLineSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TimeLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timeline
     *
     * @mbggenerated Thu Jul 06 21:47:40 CST 2017
     */
    @Update({
        "update timeline",
        "set content = #{content,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "year = #{year,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "time = #{time,jdbcType=VARCHAR},",
          "important = #{important,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TimeLine record);

    class TimeLineSqlProvider {

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String countByExample(TimeLineExample example) {
            BEGIN();
            SELECT("count(*)");
            FROM("timeline");
            applyWhere(example, false);
            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String deleteByExample(TimeLineExample example) {
            BEGIN();
            DELETE_FROM("timeline");
            applyWhere(example, false);
            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String insertSelective(TimeLine record) {
            BEGIN();
            INSERT_INTO("timeline");

            if (record.getId() != null) {
                VALUES("id", "#{id,jdbcType=INTEGER}");
            }

            if (record.getContent() != null) {
                VALUES("content", "#{content,jdbcType=VARCHAR}");
            }

            if (record.getTitle() != null) {
                VALUES("title", "#{title,jdbcType=VARCHAR}");
            }

            if (record.getYear() != null) {
                VALUES("year", "#{year,jdbcType=VARCHAR}");
            }

            if (record.getCreatetime() != null) {
                VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
            }

            if (record.getTime() != null) {
                VALUES("time", "#{time,jdbcType=VARCHAR}");
            }

            if (record.getImportant() != null) {
                VALUES("important", "#{important,jdbcType=INTEGER}");
            }

            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String selectByExample(TimeLineExample example) {
            BEGIN();
            if (example != null && example.isDistinct()) {
                SELECT_DISTINCT("id");
            } else {
                SELECT("id");
            }
            SELECT("content");
            SELECT("title");
            SELECT("year");
            SELECT("createtime");
            SELECT("time");
            SELECT("important");
            FROM("timeline");
            applyWhere(example, false);

            if (example != null && example.getOrderByClause() != null) {
                ORDER_BY(example.getOrderByClause());
            }

            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String updateByExampleSelective(Map<String, Object> parameter) {
            TimeLine record = (TimeLine) parameter.get("record");
            TimeLineExample example = (TimeLineExample) parameter.get("example");

            BEGIN();
            UPDATE("timeline");

            if (record.getId() != null) {
                SET("id = #{record.id,jdbcType=INTEGER}");
            }

            if (record.getContent() != null) {
                SET("content = #{record.content,jdbcType=VARCHAR}");
            }

            if (record.getTitle() != null) {
                SET("title = #{record.title,jdbcType=VARCHAR}");
            }

            if (record.getYear() != null) {
                SET("year = #{record.year,jdbcType=VARCHAR}");
            }

            if (record.getCreatetime() != null) {
                SET("createtime = #{record.createtime,jdbcType=TIMESTAMP}");
            }

            if (record.getTime() != null) {
                SET("time = #{record.time,jdbcType=VARCHAR}");
            }

            if (record.getImportant() != null) {
                SET("important = #{record.important,jdbcType=INTEGER}");
            }

            applyWhere(example, true);
            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String updateByExample(Map<String, Object> parameter) {
            BEGIN();
            UPDATE("timeline");

            SET("id = #{record.id,jdbcType=INTEGER}");
            SET("content = #{record.content,jdbcType=VARCHAR}");
            SET("title = #{record.title,jdbcType=VARCHAR}");
            SET("year = #{record.year,jdbcType=VARCHAR}");
            SET("createtime = #{record.createtime,jdbcType=TIMESTAMP}");
            SET("time = #{record.time,jdbcType=VARCHAR}");
            SET("important = #{record.important,jdbcType=INTEGER}");

            TimeLineExample example = (TimeLineExample) parameter.get("example");
            applyWhere(example, true);
            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        public String updateByPrimaryKeySelective(TimeLine record) {
            BEGIN();
            UPDATE("timeline");

            if (record.getContent() != null) {
                SET("content = #{content,jdbcType=VARCHAR}");
            }

            if (record.getTitle() != null) {
                SET("title = #{title,jdbcType=VARCHAR}");
            }

            if (record.getYear() != null) {
                SET("year = #{year,jdbcType=VARCHAR}");
            }

            if (record.getCreatetime() != null) {
                SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
            }

            if (record.getTime() != null) {
                SET("time = #{time,jdbcType=VARCHAR}");
            }

            if (record.getImportant() != null) {
                SET("important = #{important,jdbcType=INTEGER}");
            }

            WHERE("id = #{id,jdbcType=INTEGER}");

            return SQL();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table timeline
         *
         * @mbggenerated Thu Jul 06 21:47:40 CST 2017
         */
        protected void applyWhere(TimeLineExample example, boolean includeExamplePhrase) {
            if (example == null) {
                return;
            }

            String parmPhrase1;
            String parmPhrase1_th;
            String parmPhrase2;
            String parmPhrase2_th;
            String parmPhrase3;
            String parmPhrase3_th;
            if (includeExamplePhrase) {
                parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
                parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
                parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
                parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
                parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
                parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
            } else {
                parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
                parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
                parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
                parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
                parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
                parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
            }

            StringBuilder sb = new StringBuilder();
            List<TimeLineExample.Criteria> oredCriteria = example.getOredCriteria();
            boolean firstCriteria = true;
            for (int i = 0; i < oredCriteria.size(); i++) {
                TimeLineExample.Criteria criteria = oredCriteria.get(i);
                if (criteria.isValid()) {
                    if (firstCriteria) {
                        firstCriteria = false;
                    } else {
                        sb.append(" or ");
                    }

                    sb.append('(');
                    List<TimeLineExample.Criterion> criterions = criteria.getAllCriteria();
                    boolean firstCriterion = true;
                    for (int j = 0; j < criterions.size(); j++) {
                        TimeLineExample.Criterion criterion = criterions.get(j);
                        if (firstCriterion) {
                            firstCriterion = false;
                        } else {
                            sb.append(" and ");
                        }

                        if (criterion.isNoValue()) {
                            sb.append(criterion.getCondition());
                        } else if (criterion.isSingleValue()) {
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                            } else {
                                sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                            }
                        } else if (criterion.isBetweenValue()) {
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                            } else {
                                sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                            }
                        } else if (criterion.isListValue()) {
                            sb.append(criterion.getCondition());
                            sb.append(" (");
                            List<?> listItems = (List<?>) criterion.getValue();
                            boolean comma = false;
                            for (int k = 0; k < listItems.size(); k++) {
                                if (comma) {
                                    sb.append(", ");
                                } else {
                                    comma = true;
                                }
                                if (criterion.getTypeHandler() == null) {
                                    sb.append(String.format(parmPhrase3, i, j, k));
                                } else {
                                    sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                                }
                            }
                            sb.append(')');
                        }
                    }
                    sb.append(')');
                }
            }

            if (sb.length() > 0) {
                WHERE(sb.toString());
            }
        }
    }
}