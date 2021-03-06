package com.cdk8s.sculptor.pojo.bo.service.reldeptuser;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class RelDeptUserCreateServiceBO implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long id;
	private Long deptId;
	private Long userId;
	private Long createDate;
	private Long createUserId;

}
