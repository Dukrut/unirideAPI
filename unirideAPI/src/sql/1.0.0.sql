SET GLOBAL event_scheduler = ON;

DELIMITER $$

CREATE 
    EVENT `session_validator` 
    ON SCHEDULE EVERY 1 MINUTE 
    DO BEGIN

      DELETE FROM uniride.session WHERE TIMESTAMPDIFF(second, last_action_at, NOW()) > 900;

    END $$

DELIMITER ;