package com.citrus.backoffice.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewStatusTranslator;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;

public class TranslatorTest {

	@Tag("Unit")
	@Test
	void canGetInterviewStatus() {
		assertEquals(InterviewStatusTranslator.getStatus(0), new InterviewStatus("Creada"));
		assertEquals(InterviewStatusTranslator.getStatus(1), new InterviewStatus("Agendada"));
		assertEquals(InterviewStatusTranslator.getStatus(2), new InterviewStatus("Aprovada"));
		assertEquals(InterviewStatusTranslator.getStatus(3), new InterviewStatus("Rechazada"));
	}

}
