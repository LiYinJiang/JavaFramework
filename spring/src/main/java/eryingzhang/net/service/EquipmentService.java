package eryingzhang.net.service;

import org.springframework.stereotype.Component;

@Component("e")
public class EquipmentService {

	public void list() {

		try {
			System.out.println("EquipmentService list");
			Thread.sleep(1000 * 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
