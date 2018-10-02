package com.minance.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minance.Repository.DeviceRepository;
import com.minance.Repository.EmployeeRepository;
import com.minance.model.Device;

@RestController
@RequestMapping(value = "api/v1/device")
public class DeviceController {

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/{deviceId}/devices")
	public Device getAllDeviceByEmployeeId(@PathVariable (value = "deviceId") Long deviceId)
	{
		return deviceRepository.getOne(deviceId);
	}
	
	
	@GetMapping("/devices")
	public List<Device> getAllDevices()
	{
		return deviceRepository.findAll();
	}


	@PostMapping("/employees/{employeeId}/devices")
	public Device createDevice(@PathVariable (value = "employeeId") Long employeeId,
			@Valid @RequestBody Device device) throws Exception {
		return employeeRepository.findById(employeeId).map(employee -> {
			device.setEmployee(employee);
			return deviceRepository.save(device);
		}).orElseThrow(() -> new Exception("employeeId " + employeeId + " not found"));
	}


	@PutMapping("/employees/{employeeId}/devices/{deviceId}")
	public Device updateComment(@PathVariable (value = "employeeId") Long employeeId,
			@PathVariable (value = "deviceId") Long deviceId,
			@Valid @RequestBody Device commentRequest) throws Exception {
		if(!employeeRepository.existsById(employeeId)) {
			throw new Exception("EmployeeID " + employeeId + " not found");
		}

		return deviceRepository.findById(deviceId).map(device -> {
			device.setName(commentRequest.getName());
			return deviceRepository.save(device);
		}).orElseThrow(() -> new Exception("DeviceID " + deviceId + "not found"));
	}



	@DeleteMapping("/employees/{employeeId}/devices/{deviceId}")
	public ResponseEntity<?> deleteComment(@PathVariable (value = "employeeId") Long employeeId,
			@PathVariable (value = "deviceId") Long deviceId) throws Exception{
		if(!employeeRepository.existsById(employeeId)) {
			throw new Exception("employeeId " + employeeId + " not found");
		}

		return deviceRepository.findById(deviceId).map(device -> {
			deviceRepository.delete(device);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("CommentId " + deviceId + " not found"));
	}

}
