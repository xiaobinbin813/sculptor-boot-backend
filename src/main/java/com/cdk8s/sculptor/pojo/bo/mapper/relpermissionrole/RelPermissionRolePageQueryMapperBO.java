package com.cdk8s.sculptor.pojo.bo.mapper.relpermissionrole;

import com.cdk8s.sculptor.pojo.dto.param.bases.PageParam;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class RelPermissionRolePageQueryMapperBO extends PageParam {

	private static final long serialVersionUID = -1L;

	private Long id;
	private Long permissionId;
	private Long roleId;
	private Long createUserId;


}
