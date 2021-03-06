/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.is.migration.service.v530.migrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.identity.core.migrate.MigrationClientException;
import org.wso2.carbon.is.migration.service.Migrator;
import org.wso2.carbon.is.migration.service.v530.RegistryDataManager;

/**
 * Migration implementation for Challenge questions
 */
public class ChallengeQuestionDataMigrator extends Migrator {

    private static final Logger log = LoggerFactory.getLogger(ChallengeQuestionDataMigrator.class);

    @Override
    public void migrate() throws MigrationClientException {
        migrateChallengeQuestionData();
    }

    @Override
    public void dryRun() throws MigrationClientException {

        log.info("Dry run capability not implemented in {} migrator.", this.getClass().getName());
    }

    public void migrateChallengeQuestionData()  {

        RegistryDataManager registryDataManager = RegistryDataManager.getInstance();
        try {
            registryDataManager.migrateChallengeQuestions(isIgnoreForInactiveTenants(), isContinueOnError());
        } catch (Exception e) {
            log.error("Error while migrating challange questions", e);
        }
    }
}
