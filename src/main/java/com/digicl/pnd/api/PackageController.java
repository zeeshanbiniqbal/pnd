package com.digicl.pnd.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digicl.pnd.dto.PackageDTO;

@RestController
@RequestMapping("/package")
public class PackageController extends GenericController<PackageDTO> {

}
