package com.digicl.pnd.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digicl.pnd.dto.ServiceProviderDTO;

@RestController
@RequestMapping("/sp")
public class SpController extends GenericController<ServiceProviderDTO> {

}
