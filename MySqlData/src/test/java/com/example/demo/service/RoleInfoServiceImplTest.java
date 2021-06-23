package com.example.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Application;
import com.example.demo.model.RoleInfo;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.RoleInfoVO1;

 



 

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RoleInfoServiceImpl.class)
public class RoleInfoServiceImplTest {

 

    @MockBean
    private RoleInfoRepo roleInfoRepository;

 

    @MockBean
    private ApplicationRepo applicationrepository;

 

    @Autowired
    private RoleInfoService roleinfoservice;

 

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

 

    private RoleInfo getRoleInfo() {
        RoleInfo role = new RoleInfo();
        role.setId(10);
        role.setCreatedby("ak");
        role.setCreatedon(null);
        role.setUpdatedby("ak");
        role.setRolecode(101);
        role.setRolename("Software Engineer");
      //  role.setApplicationId(1);
        role.setIsactive('Y');
        return role;
    }

 

    private RoleInfo getRoleInfo1() {
        RoleInfo role = new RoleInfo();
        role.setId(10);
        role.setCreatedby("ak");
        role.setCreatedon(null);
        role.setUpdatedby("ak");
        role.setRolecode(101);
        role.setRolename("Software Engineer");
      //  role.setApplicationId(1);
        role.setIsactive('Y');
        return role;
    }

 

    private Application getApplication() {
        Application app = new Application();
        app.setApplicationId(1);
        app.setApplicationKey("A1");
        app.setApplicationname("LinkedIn");
        app.setCreated_by("Sonal Sinha");
        app.setUpdated_by("ak");
        return app;
    }

 

    @Test
    public void getRoleTest() {
        List<RoleInfoVO1> roleInfoList = new ArrayList<>();
        List<RoleInfo> roleInfo = Stream.of(getRoleInfo()).collect(Collectors.toList());
        when(roleInfoRepository.findAll()).thenReturn(roleInfo);
        for (RoleInfo role : roleInfo) {
            RoleInfoVO1 roleInfoVO = new RoleInfoVO1();
            roleInfoVO.setCreated_by(role.getCreatedby());
            roleInfoVO.setCreated_on(role.getCreatedon());
            roleInfoVO.setUpdated_by(role.getUpdatedby());
            roleInfoVO.setRolecode(role.getRolecode());
            roleInfoVO.setRolename(role.getRolename());
            roleInfoList.add(roleInfoVO);
        }
        roleInfoList = roleinfoservice.getAllRoleInfo();
        assertNotNull(roleInfoList);
    }

 

    @Test
    public void getRoleByApplicationkeyTest() {

 

        String applicationkey = "A1";

 

        List<RoleInfoVO> rinfoVo1 = new ArrayList<>();
        Application application = getApplication();
        when(applicationrepository.findByApplicationKey("A1")).thenReturn(application);
        int appid = application.getApplicationId();
        List<RoleInfo> roleInfo = Stream.of(getRoleInfo()).collect(Collectors.toList());
        when(roleInfoRepository.findByApplicationApplicationId(appid)).thenReturn(roleInfo);
        for (RoleInfo role1 : roleInfo) {

 

            RoleInfoVO roleInfoVo = new RoleInfoVO();
            roleInfoVo.setRoleName(role1.getRolename());
            roleInfoVo.setRoleId(role1.getId());
            roleInfoVo.setRoleCode(role1.getRolecode());

 

            role1.getIsactive().equals("Y");
            roleInfoVo.setStatus("true");

 

        }

 

        rinfoVo1 = roleinfoservice.getByApplicationKey(applicationkey);
        assertNotNull(rinfoVo1);

 

    }

 

    @Test
    public void getRoleByApplicationkeyElseTest() {

 

        String applicationkey = "A1";

 

        List<RoleInfoVO> rinfoVo1 = new ArrayList<>();
        Application application = getApplication();
        when(applicationrepository.findByApplicationKey("A1")).thenReturn(application);
        int appid = application.getApplicationId();
        List<RoleInfo> roleInfo = Stream.of(getRoleInfo1()).collect(Collectors.toList());
        when(roleInfoRepository.findByApplicationApplicationId(appid)).thenReturn(roleInfo);
        for (RoleInfo role1 : roleInfo) {

 

            RoleInfoVO roleInfoVo = new RoleInfoVO();
            roleInfoVo.setRoleName(role1.getRolename());
            roleInfoVo.setRoleId(role1.getId());
            roleInfoVo.setRoleCode(role1.getRolecode());

 

            role1.getIsactive().equals("N");
            roleInfoVo.setStatus("false");

 

        }

 

        rinfoVo1 = roleinfoservice.getByApplicationKey(applicationkey);
        assertNotNull(rinfoVo1);

 

    }

 

    @Test
    public void getRoleByApplicationkeyapplicationnull() {

 

        String applicationkey = "A1";

 

        List<RoleInfoVO> rinfoVo1 = new ArrayList<>();
        Application application = null;
        when(applicationrepository.findByApplicationKey("A1")).thenReturn(application);

 

        rinfoVo1 = roleinfoservice.getByApplicationKey(applicationkey);
        assertNull(rinfoVo1);

 

    }

 

}