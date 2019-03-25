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
@TableName("dormitory_room")
public class DormitoryRoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宿舍名
     */
    @TableField("room_name")
    private String roomName;

    /**
     * 校区编号
     */
    @TableField("campus_id")
    private Integer campusId;

    /**
     * 宿舍楼编号
     */
    @TableField("floor_id")
    private Integer floorId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 删除
     */
    @TableField("status")
    private Integer status;

    /**
     * 开放
     */
    @TableField("open")
    private Integer open;


}
