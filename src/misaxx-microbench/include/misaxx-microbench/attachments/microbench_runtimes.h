/**
 * Copyright by Ruman Gerst
 * Research Group Applied Systems Biology - Head: Prof. Dr. Marc Thilo Figge
 * https://www.leibniz-hki.de/en/applied-systems-biology.html
 * HKI-Center for Systems Biology of Infection
 * Leibniz Institute for Natural Product Research and Infection Biology - Hans Knöll Insitute (HKI)
 * Adolf-Reichwein-Straße 23, 07745 Jena, Germany
 *
 * This code is licensed under BSD 2-Clause
 * See the LICENSE file provided with this code for the full license.
 */

#pragma once

#include <misaxx/core/attachments/misa_locatable.h>

namespace misaxx_microbench {
    struct microbench_runtimes : public misaxx::misa_locatable {

        std::unordered_map<std::string, double> data;

        void from_json(const nlohmann::json &t_json) override;

        void to_json(nlohmann::json &t_json) const override;

        void to_json_schema(misaxx::misa_json_schema_property &t_schema) const override;

    protected:
        void build_serialization_id_hierarchy(std::vector<misaxx::misa_serialization_id> &result) const override;
    };
}

inline void to_json(nlohmann::json &j, const misaxx_microbench::microbench_runtimes &p) {
    p.to_json(j);
}

inline void from_json(const nlohmann::json &j, misaxx_microbench::microbench_runtimes &p) {
    p.from_json(j);
}
