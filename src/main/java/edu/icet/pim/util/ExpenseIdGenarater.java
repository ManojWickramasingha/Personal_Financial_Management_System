package edu.icet.pim.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExpenseIdGenarater implements IdentifierGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseIdGenarater.class);
    private static final String PREFIX = "EXP";
    private static final int PREFIX_LENGTH = 3;
    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        String lastId = "SELECT e.id FROM Expense e ORDER BY e.id DESC LIMIT 1";
        int nextId = 1;

        try {
            nextId = parseIdSafely(lastId) + 1;
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid ID format for Expense entity: " + lastId, e);
        }

        return PREFIX + String.format("%03d", nextId);
    }

    private int parseIdSafely(String lastId) {
        if (lastId != null && lastId.length() > PREFIX_LENGTH) {
            try {
                return Integer.parseInt(lastId.substring(PREFIX_LENGTH));
            } catch (NumberFormatException e) {
                logger.warn("Failed to parse ID number from '{}'. Defaulting to 0.", lastId, e);
            }
        }
        return 0;
    }
}
