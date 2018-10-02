package com.minance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minance.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long > {

}