TestCondition : UnitTest {

	test_timeout {
		var condition = Condition.new;
		var failed = false;
		var lateTask = fork {
			0.12.wait;
			failed = true;
			condition.unhang;
		};
		condition.hang(1e-6);
		lateTask.stop;
		this.assert(failed.not, "condition has timed out")
	}

}
