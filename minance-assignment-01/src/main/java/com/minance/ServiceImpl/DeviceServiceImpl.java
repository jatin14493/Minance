//package com.minance.ServiceImpl;
//
//import java.sql.Timestamp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.minance.Repository.DeviceRepository;
//import com.minance.Service.DeviceService;
//import com.minance.model.Device;
//import com.minance.model.DeviceCreateRequest;
//
//@Service
//public class DeviceServiceImpl implements DeviceService {
//
//	@Autowired
//	DeviceRepository deviceRepository;
//
//	@Override
//	public Device createDevice(DeviceCreateRequest createRequest) {
//		// TODO Auto-generated method stub
//		Device device = new Device();
//		device.setDeviceId(createRequest.getDeviceId());
//		device.setName(createRequest.getName());
//		device.setCreateDate(new Timestamp(System.currentTimeMillis()));
//		return deviceRepository.save(device);
//	}
//
//	@Override
//	public Device updateDevice(DeviceCreateRequest createRequest, Long id) {
//		Device d = deviceRepository.getOne(id);
//
//		d.setName(createRequest.getName());
//		d.setModifyDate(new Timestamp(System.currentTimeMillis()));
//
//		if(null!=createRequest.getDeviceId()) {
//			d.setDeviceId(createRequest.getDeviceId());
//		}
//		return deviceRepository.save(d);
//	}
//
//	@Override
//	public Boolean DeleteDevice(Long id) {
//		// TODO Auto-generated method stub
//		Boolean isDeleted = false;
//		try {
//			deviceRepository.deleteById(id);
//			isDeleted = true;
//		}catch(Exception ex) {
//			System.out.println("Exception came while Deleting Device");
//		}
//		return isDeleted;
//	}
//
//}
