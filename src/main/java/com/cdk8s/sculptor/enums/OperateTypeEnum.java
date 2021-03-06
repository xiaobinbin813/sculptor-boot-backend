package com.cdk8s.sculptor.enums;

import java.util.HashMap;
import java.util.Map;

public enum OperateTypeEnum implements BasicEnum {
	QUERY(1, "查询"),
	CREATE(2, "创建"),
	UPDATE_INFO(3, "修改对象"),
	UPDATE_STATE(4, "修改状态"),
	DELETE(5, "删除"),
	IMPORT(6, "导入"),
	EXPORT(7, "导出");

	private Integer code;
	private String description;

	OperateTypeEnum(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static Map<Integer, String> getAllEnum() {
		Map<Integer, String> map = new HashMap<>();
		OperateTypeEnum[] allEnums = values();
		for (OperateTypeEnum enumObject : allEnums) {
			map.put(enumObject.getCode(), enumObject.getDescription());
		}
		return map;
	}

	public static OperateTypeEnum getEnumByCode(Integer code) {
		if (null == code) {
			return null;
		}
		OperateTypeEnum[] allEnums = values();
		for (OperateTypeEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject;
			}
		}
		return null;
	}

	public static String getDescriptionByCode(Integer code) {
		if (null == code) {
			return null;
		}
		OperateTypeEnum[] allEnums = values();
		for (OperateTypeEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject.getDescription();
			}
		}
		return null;
	}

	public static String getNameByCode(Integer code) {
		if (null == code) {
			return null;
		}
		OperateTypeEnum[] allEnums = values();
		for (OperateTypeEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject.name();
			}
		}
		return null;
	}
}
