package com.cdk8s.sculptor.pojo.dto.param.oauth.resolve;

import com.cdk8s.sculptor.pojo.dto.param.oauth.OauthFormLoginParam;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class OauthFormParamArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(OauthFormLoginParam.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
		OauthFormLoginParam param = new OauthFormLoginParam();
		param.setUsername(nativeWebRequest.getParameter("username"));
		param.setPassword(nativeWebRequest.getParameter("password"));
		param.setDeviceId(nativeWebRequest.getParameter("device_id"));
		param.setValidateCode(nativeWebRequest.getParameter("validate_code"));
		param.setResponseType(nativeWebRequest.getParameter("response_type"));
		param.setClientId(nativeWebRequest.getParameter("client_id"));
		param.setRedirectUri(nativeWebRequest.getParameter("redirect_uri"));
		param.setState(nativeWebRequest.getParameter("state"));
		param.setBoolIsRememberMe(Boolean.valueOf(nativeWebRequest.getParameter("bool_is_remember_me")));
		return param;
	}

}
