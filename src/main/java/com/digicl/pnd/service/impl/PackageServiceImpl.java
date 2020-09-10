package com.digicl.pnd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicl.pnd.dto.PackageDTO;
import com.digicl.pnd.exception.EntityNotFoundException;
import com.digicl.pnd.model.PdPackage;
import com.digicl.pnd.repository.PdPackageRepository;
import com.digicl.pnd.service.PackageService;
import com.digicl.pnd.util.Constant;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	PdPackageRepository packageRepository;

	@Override
	public PackageDTO create(PackageDTO dto) {
		
		PdPackage pdPackage = new PdPackage();
		BeanUtils.copyProperties(dto, pdPackage);
		packageRepository.save(pdPackage);
		return dto;
	}

	@Override
	public PackageDTO read(Long id) {
		
		PdPackage pdPackage = packageRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND));

		PackageDTO packageDTO = new PackageDTO();

		BeanUtils.copyProperties(pdPackage, packageDTO);

		return packageDTO;
	}

	@Override
	public List<PackageDTO> readAll() {
		
		List<PackageDTO> packageDTOs = null;
		List<PdPackage> pdPackages = (List<PdPackage>) packageRepository.findAll();

		if (!pdPackages.isEmpty()) {
			packageDTOs = new ArrayList<>();

			for (PdPackage pdPackage : pdPackages) {
				PackageDTO packageDTO = new PackageDTO();
				BeanUtils.copyProperties(pdPackage, packageDTO);
				packageDTOs.add(packageDTO);
			}
		} else {
			throw new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND);
		}

		return packageDTOs;
	}

	@Override
	public PackageDTO update(PackageDTO dto) {
		
		PdPackage pdPackage = packageRepository.findById(dto.getPackageId())
				.orElseThrow(() -> new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND));
		
		BeanUtils.copyProperties(dto, pdPackage);
		packageRepository.save(pdPackage);
		
		return dto;
	}

	@Override
	public PackageDTO delete(Long id) {
		
		PdPackage pdPackage = packageRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(PdPackage.class, Constant.MESSAGE_ENTITY_NOT_FOUND));

		packageRepository.deleteById(id);

		return new PackageDTO(pdPackage.getPackageId());
	}

}
