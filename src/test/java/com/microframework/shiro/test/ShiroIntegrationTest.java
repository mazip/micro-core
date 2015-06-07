package com.microframework.shiro.test;

import java.nio.charset.Charset;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.apache.shiro.mgt.SecurityManager;

import com.microframework.base.test.JUnit4ClassRunner;
import com.microframework.controller.LoginController;

@RunWith(JUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/java/spring/servlet-context.xml" })
public class ShiroIntegrationTest extends AbstractShiroTest {

	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	protected MockHttpSession mockSession;

	@Autowired
	private LoginController loginController;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		// final Authenticate bean = (Authenticate) wac.getBean("authenticate");
		//
		// Subject subjectUnderTest = new Subject.Builder(getSecurityManager())
		// .buildSubject();
		// mockSession = new MockHttpSession(wac.getServletContext(),
		// subjectUnderTest.getSession().getId().toString());
		// // 2. Bind the subject to the current thread:
		// setSubject(subjectUnderTest);
		// bean.logon("User01", "User01", mockSession.getId());
	}

	@Test
	public void testLogin() throws Exception {
		Subject subjectUnderTest = new Subject.Builder(getSecurityManager())
				.buildSubject();
		mockSession = new MockHttpSession(wac.getServletContext(),
				subjectUnderTest.getSession().getId().toString());

		setSubject(subjectUnderTest);

        //username password rememberMe
		String s = (String) this.mockMvc.perform(MockMvcRequestBuilders.post("/login","admin","admin",true)).andReturn().getRequest().getAttribute("shiroLoginFailure");
		System.out.println("登录结果:"+s);

	}

}
