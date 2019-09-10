package com.woniuxy.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.Attendance;
import com.woniuxy.mapper.AttendanceMapper;
import com.woniuxy.service.AttendanceService;
/**考勤表service实现类
 * @刘立英
 */
@Service
public class AttendanceServiceImp implements AttendanceService{
	@Autowired
	AttendanceMapper attendanceMapper;
	//查询
	@Override
	public Attendance showAttendance() {
		Attendance attendance = attendanceMapper.selectByPrimaryKey(1);
		return attendance;
	}
	//修改
	@Override
	public void updateAttendance(Attendance attendance) {
		attendanceMapper.updateByPrimaryKey(attendance);
		
	}
}
