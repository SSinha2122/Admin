package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Application;
import com.example.demo.model.RoleInfo;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.RoleInfoVO1;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	RoleInfoRepo roleInfoRepo;
	
	@Autowired
	ApplicationRepo applicationRepo;

	@Override
	public List<RoleInfoVO> findAll() {

		ArrayList<RoleInfoVO> result = new ArrayList<>();
		List<RoleInfo> roleInfo = roleInfoRepo.findAll();
		for (int i = 0; i < roleInfo.size(); i++) {
			RoleInfoVO roleInfoVO = new RoleInfoVO();
			//roleInfoVO.setApplicationName(roleInfo.get(i).getApplication().getApplicationname());
			roleInfoVO.setRoleCode(roleInfo.get(i).getRolecode());
			roleInfoVO.setRoleName(roleInfo.get(i).getRolename());
			result.add(roleInfoVO);
		}
		return result;
	}

	@Override
	public List<RoleInfoVO> getbyApplicationId(Integer appId) {
		List<RoleInfoVO> result = new ArrayList<>();
		List<RoleInfo> roleInfo = roleInfoRepo.findByApplicationApplicationId(appId);
		for (int i = 0; i < roleInfo.size(); i++) {
			RoleInfoVO roleInfoVO = new RoleInfoVO();
			//roleInfoVO.setApplicationName(roleInfo.get(i).getApplication().getApplicationname());
			roleInfoVO.setRoleCode(roleInfo.get(i).getRolecode());
			roleInfoVO.setRoleName(roleInfo.get(i).getRolename());
			result.add(roleInfoVO);
		}
		return result;
	}

	@Override
    public List<RoleInfoVO1> getAllRoleInfo() {

 

        List<RoleInfo> rinfo = roleInfoRepo.findAll();
        List<RoleInfoVO1> rinfoVo = new ArrayList<>();
        for (RoleInfo role : rinfo) {
            RoleInfoVO1 roleInfoVo = new RoleInfoVO1();
            /*if (role.getApplication() != null) {
                roleInfoVo.setApplicationname(role.getApplication().getApplicationName());
                roleInfoVo.setApplicationkey(role.getApplication().getApplicationKey());
            }*/
            roleInfoVo.setCreated_by(role.getCreatedby());
            roleInfoVo.setCreated_on(role.getCreatedon());
            roleInfoVo.setRolecode(role.getRolecode());
            roleInfoVo.setRolename(role.getRolename());
          
            rinfoVo.add(roleInfoVo);

 

        }
        return rinfoVo;
    }
 
	
	
	@Override
     public List<RoleInfoVO> getByApplicationKey(String applicationKey) {



       Application application = applicationRepo.findByApplicationKey(applicationKey);
       List<RoleInfoVO> rinfoVo1 = new ArrayList<>();



       if (application != null) {



           int appid = application.getApplicationId();
           List<RoleInfo> rinfo = roleInfoRepo.findByApplicationApplicationId(appid);
           //List<RoleInfoVo1> rinfoVo1 = new ArrayList<>();
           for (RoleInfo role : rinfo) {



                   RoleInfoVO roleInfoVo = new RoleInfoVO();
                   roleInfoVo.setRoleName(role.getRolename());
                   roleInfoVo.setRoleId(role.getId());
                   roleInfoVo.setRoleCode(role.getRolecode());



                   if (role.getIsactive().equals("Y")) {
                       roleInfoVo.setStatus("true");
                   } else {
                       roleInfoVo.setStatus("false");
                   }
                   rinfoVo1.add(roleInfoVo);
               
           }
           return rinfoVo1;
       } else {
           System.out.println("No Application Key Found so returns null list");
           return null;}
   }

	

}
