package com.cdk8s.sculptor.service;

import com.cdk8s.sculptor.Application;
import com.cdk8s.sculptor.constant.GlobalConstantToJunit;
import com.cdk8s.sculptor.enums.DeleteEnum;
import com.cdk8s.sculptor.enums.ParamValueTypeEnum;
import com.cdk8s.sculptor.enums.StateEnum;
import com.cdk8s.sculptor.pojo.bo.service.bases.BatchDeleteServiceBO;
import com.cdk8s.sculptor.pojo.bo.service.bases.BatchUpdateStateServiceBO;
import com.cdk8s.sculptor.pojo.bo.service.sysparam.SysParamCreateServiceBO;
import com.cdk8s.sculptor.pojo.bo.service.sysparam.SysParamPageQueryServiceBO;
import com.cdk8s.sculptor.pojo.bo.service.sysparam.SysParamUpdateServiceBO;
import com.cdk8s.sculptor.pojo.entity.SysParam;
import com.cdk8s.sculptor.util.DatetimeUtil;
import com.cdk8s.sculptor.util.RandomUtil;
import com.cdk8s.sculptor.util.UserInfoContext;
import com.cdk8s.sculptor.util.id.GenerateIdUtil;
import com.cdk8s.tkey.client.rest.pojo.dto.OauthUserAttribute;
import com.cdk8s.tkey.client.rest.pojo.dto.OauthUserProfile;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SysParamServiceTest {

	private static final Long ID = GenerateIdUtil.getId();

	@Autowired
	private SysParamService sysParamService;

	// =====================================预处理 start=====================================

	@SneakyThrows
	@BeforeClass
	public static void a_beforeClass() {
		OauthUserProfile oauthUserProfile = new OauthUserProfile();
		oauthUserProfile.setUsername(GlobalConstantToJunit.USERNAME);
		oauthUserProfile.setName(GlobalConstantToJunit.USERNAME);
		oauthUserProfile.setId(GlobalConstantToJunit.USER_ID);
		oauthUserProfile.setUserId(GlobalConstantToJunit.USER_ID);
		OauthUserAttribute oauthUserAttribute = new OauthUserAttribute();
		oauthUserAttribute.setEmail(GlobalConstantToJunit.USER_EMAIL);
		oauthUserAttribute.setUserId(GlobalConstantToJunit.USER_ID);
		oauthUserAttribute.setUsername(GlobalConstantToJunit.USERNAME);
		oauthUserProfile.setUserAttribute(oauthUserAttribute);
		UserInfoContext.setCurrentUser(oauthUserProfile);
	}

	// =====================================预处理 end=====================================
	// =====================================查询业务 start=====================================

	@Test
	public void a_findOneById() {
		SysParam result = sysParamService.findOneById(ID);

		assertThat(result, Matchers.notNullValue());
	}

	@Test
	public void a_findListByIdList() {
		ArrayList<Long> idList = Lists.newArrayList(ID, 222222222222222222L);
		List<SysParam> result = sysParamService.findListByIdList(idList);

		assertThat(result.size(), Matchers.greaterThan(0));
	}

	@Test
	public void a_findListByServiceBO() {
		SysParamPageQueryServiceBO serviceBO = new SysParamPageQueryServiceBO();
		serviceBO.setStateEnum(StateEnum.ENABLE.getCode());
		serviceBO.setDeleteEnum(DeleteEnum.NOT_DELETED.getCode());
		serviceBO.setCreateDateStartDate(631183520000L);
		serviceBO.setCreateDateEndDate(1893487520000L);

		List<SysParam> result = sysParamService.findListByServiceBO(serviceBO);

		assertThat(result.size(), Matchers.greaterThan(0));
	}

	@Test
	public void a_findPageByServiceBO() {
		SysParamPageQueryServiceBO serviceBO = new SysParamPageQueryServiceBO();
		serviceBO.setStateEnum(StateEnum.ENABLE.getCode());
		serviceBO.setDeleteEnum(DeleteEnum.NOT_DELETED.getCode());
		serviceBO.setPageNum(1);
		serviceBO.setPageSize(10);
		serviceBO.setCreateDateStartDate(631183520000L);
		serviceBO.setCreateDateEndDate(1893487520000L);

		PageInfo result = sysParamService.findPageByServiceBO(serviceBO);

		assertThat(result.getList().size(), Matchers.greaterThan(0));
	}

	// =====================================查询业务 end=====================================
	// =====================================操作业务 start=====================================

	@Test
	public void a_create() {
		long currentEpochMilli = DatetimeUtil.currentEpochMilli();
		Long currentUserId = UserInfoContext.getCurrentUserId();

		SysParamCreateServiceBO serviceBO = new SysParamCreateServiceBO();
		// 根据业务补充其他属性：RandomUtil.randomAlphabetic(6)
		serviceBO.setId(ID);
		serviceBO.setTypeId(111111111111111111L);
		serviceBO.setParamName(RandomUtil.randomAlphabetic(6));
		serviceBO.setParamCode(RandomUtil.randomAlphabetic(6));
		serviceBO.setRanking(100);
		serviceBO.setParamValueTypeEnum(ParamValueTypeEnum.String.getCode());
		serviceBO.setStateEnum(StateEnum.ENABLE.getCode());

		serviceBO.setRanking(100);
		serviceBO.setStateEnum(StateEnum.ENABLE.getCode());
		serviceBO.setDeleteEnum(DeleteEnum.NOT_DELETED.getCode());
		serviceBO.setCreateDate(currentEpochMilli);
		serviceBO.setCreateUserId(currentUserId);
		serviceBO.setUpdateDate(currentEpochMilli);
		serviceBO.setUpdateUserId(currentUserId);

		Integer result = sysParamService.create(serviceBO);

		assertThat(result, Matchers.greaterThan(0));
	}

	@Transactional
	@Test
	public void b_update() {
		long currentEpochMilli = DatetimeUtil.currentEpochMilli();
		Long currentUserId = UserInfoContext.getCurrentUserId();

		SysParamUpdateServiceBO serviceBO = new SysParamUpdateServiceBO();
		// 根据业务补充其他属性：RandomUtil.randomAlphabetic(6)
		serviceBO.setId(ID);
		serviceBO.setTypeId(111111111111111111L);
		serviceBO.setParamName(RandomUtil.randomAlphabetic(6));
		serviceBO.setParamCode(RandomUtil.randomAlphabetic(6));
		serviceBO.setParamValueTypeEnum(ParamValueTypeEnum.String.getCode());

		serviceBO.setRanking(100);
		serviceBO.setStateEnum(StateEnum.ENABLE.getCode());
		serviceBO.setUpdateDate(currentEpochMilli);
		serviceBO.setUpdateUserId(currentUserId);

		Integer result = sysParamService.update(serviceBO);

		assertThat(result, Matchers.greaterThan(0));
	}

	@Transactional
	@Test
	public void b_batchUpdateState() {
		long currentEpochMilli = DatetimeUtil.currentEpochMilli();
		Long currentUserId = UserInfoContext.getCurrentUserId();

		ArrayList<Long> idList = Lists.newArrayList(ID, 222222222222222222L);
		BatchUpdateStateServiceBO serviceBO = new BatchUpdateStateServiceBO();
		serviceBO.setIdList(idList);
		serviceBO.setStateEnum(StateEnum.DISABLE.getCode());

		serviceBO.setUpdateDate(currentEpochMilli);
		serviceBO.setUpdateUserId(currentUserId);

		Integer result = sysParamService.batchUpdateState(serviceBO);

		assertThat(result, Matchers.greaterThan(0));
	}

	@Transactional
	@Test
	public void m_batchDelete() {
		long currentEpochMilli = DatetimeUtil.currentEpochMilli();
		Long currentUserId = UserInfoContext.getCurrentUserId();

		ArrayList<Long> idList = Lists.newArrayList(ID, 222222222222222222L);
		BatchDeleteServiceBO serviceBO = new BatchDeleteServiceBO();
		serviceBO.setIdList(idList);

		serviceBO.setDeleteEnum(DeleteEnum.DELETED.getCode());
		serviceBO.setDeleteDate(currentEpochMilli);
		serviceBO.setDeleteUserId(currentUserId);

		serviceBO.setUpdateDate(currentEpochMilli);
		serviceBO.setUpdateUserId(currentUserId);


		Integer result = sysParamService.batchDelete(serviceBO);

		assertThat(result, Matchers.greaterThan(0));
	}

	// =====================================操作业务 end=====================================
	// =====================================私有方法 start=====================================

	// =====================================私有方法 end=====================================
}
