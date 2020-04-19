package com.bishe.main.manager;

import com.bishe.main.dto.SandboxStatus;

import java.util.Collection;

public interface SandboxStatusObserver {
	void statusChanged(Collection<SandboxStatus> status);
}
