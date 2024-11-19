CREATE TABLE sitemap (
       id BIGINT PRIMARY KEY,
       year INT NOT NULL,
       month INT NOT NULL,
       url VARCHAR(255) NOT NULL
);

-- i don't know why quarkus need this sequenc otherwise it will throw error:
-- 2024-11-20 07:07:33,963 ERROR [io.qua.hib.orm.run.sch.SchemaManagementIntegrator] (Hibernate post-boot validation thread for <default>) Failed to validate Schema: Schema-validation: sequence [sitemap_SEQ] defined inconsistent increment-size; found [1] but expecting [50]
-- 2024-11-20 07:07:33,977 ERROR [io.qua.hib.orm.run.sch.SchemaManagementIntegrator] (Hibernate post-boot validation thread for <default>) The following SQL may resolve the database issues, as generated by the Hibernate schema migration tool. WARNING: You must manually verify this SQL is correct, this is a best effort guess, do not copy/paste it without verifying that it does what you expect.
CREATE SEQUENCE sitemap_SEQ START WITH 1 INCREMENT BY 50;