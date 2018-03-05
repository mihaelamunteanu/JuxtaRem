package com.ws.juxtarem.dao;

import com.ws.juxtarem.obj.Task;

public interface TaskDao {
	public Task findTaskByID(long id);
}
