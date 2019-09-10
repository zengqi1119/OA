package com.woniuxy.service;

import com.woniuxy.entity.Attendance;

/**考勤表service接口
 * @刘立英
 */
public interface AttendanceService {
		//查询
		Attendance showAttendance();
		//修改
		void updateAttendance(Attendance attendance);
}
