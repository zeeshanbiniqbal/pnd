package com.digicl.pnd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicl.pnd.dto.ServiceProviderDTO;
import com.digicl.pnd.exception.EntityNotFoundException;
import com.digicl.pnd.model.PdPackage;
import com.digicl.pnd.model.ServiceProvider;
import com.digicl.pnd.repository.PdPackageRepository;
import com.digicl.pnd.repository.ServiceProviderRepository;
import com.digicl.pnd.service.ServiceProviderService;
import com.digicl.pnd.util.Constant;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{
	
	@Autowired
	ServiceProviderRepository serviceProviderRepository;
	
	@Autowired
	PdPackageRepository packageRepository;

	@Override
	public ServiceProviderDTO create(ServiceProviderDTO dto) {
		
		ServiceProvider sp = new ServiceProvider();
		BeanUtils.copyProperties(dto, sp);
	
		PdPackage pdPackage = packageRepository.findById(dto.getPackageId().getPackageId())
				.orElseThrow(() -> new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND));
		
		sp.setPackageId(pdPackage);
		
		serviceProviderRepository.save(sp);
		
		return dto;
	}

	@Override
	public ServiceProviderDTO read(Long id) {
		
		ServiceProvider sp = serviceProviderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ServiceProvider.class, Constant.MESSAGE_ENTITY_NOT_FOUND));

		ServiceProviderDTO spDTO = new ServiceProviderDTO();

		BeanUtils.copyProperties(sp, spDTO);

		return spDTO;
	}

	@Override
	public List<ServiceProviderDTO> readAll() {
		
		List<ServiceProviderDTO> spDTOs = null;
		List<ServiceProvider> spList = (List<ServiceProvider>) serviceProviderRepository.findAll();

		if (!spList.isEmpty()) {
			spDTOs = new ArrayList<>();

			for (ServiceProvider sp : spList) {
				ServiceProviderDTO spDTO = new ServiceProviderDTO();
				BeanUtils.copyProperties(sp, spDTO);
				spDTOs.add(spDTO);
			}
		} else {
			throw new EntityNotFoundException(ServiceProvider.class, Constant.MESSAGE_ENTITY_NOT_FOUND);
		}

		return spDTOs;
	}

	@Override
	public ServiceProviderDTO update(ServiceProviderDTO dto) {
		
		ServiceProvider sp = serviceProviderRepository.findById(dto.getSpId())
				.orElseThrow(() -> new EntityNotFoundException(ServiceProvider.class, Constant.MESSAGE_ENTITY_NOT_FOUND));
		
		PdPackage pdPackage = packageRepository.findById(dto.getPackageId().getPackageId())
				.orElseThrow(() -> new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND));
		
		BeanUtils.copyProperties(dto, sp);
		sp.setPackageId(pdPackage);
		
		serviceProviderRepository.save(sp);
		
		return dto;
	}

	@Override
	public ServiceProviderDTO delete(Long id) {
		ServiceProvider sp = serviceProviderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ServiceProvider.class, Constant.MESSAGE_ENTITY_NOT_FOUND));

		serviceProviderRepository.deleteById(id);

		return new ServiceProviderDTO(sp.getSpId());
	}

}
