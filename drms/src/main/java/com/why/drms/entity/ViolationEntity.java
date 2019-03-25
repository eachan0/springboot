package com.why.drms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author why
 * @since 2019-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("violation")
public class ViolationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 违纪编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生编号
     */
    @TableField("stu_id")
    private Integer stuId;

    /**
     * 描述
     */
    @TableField("desc")
    private String desc;

    /**
     * 删除
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否上报
     */
    @TableField("report")
    private Integer report;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 学生名
     */
    @TableField("name")
    private String name;

    /**
     * 宿舍楼编号
     */
    @TableField("floor_id")
    private Integer floorId;

    /**
     * 宿舍编号
     */
    @TableField("room_id")
    private Integer roomId;

    /**
     * 宿舍楼名称
     */
    @TableField("floor_name")
    private String floorName;

    /**
     * 宿舍名称
     */
    @TableField("room_name")
    private String roomName;


}
