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

#include <misaxx/core/misa_module_info.h>
#include <misaxx/core/module_info.h>
#include <misaxx-tissue/module_info.h>
#include <misaxx/ome/module_info.h>

misaxx::misa_module_info misaxx_tissue::module_info() {
    misaxx::misa_module_info info;
    info.set_id("misaxx-tissue-segmentation");
    info.set_version("1.0.0");
    info.set_name("MISA++ Tissue Segmentation");
    info.set_description("Segments tissue of whole organ LSFM images");
    info.add_author("Ruman Gerst");
    info.set_license("BSD-2-Clause");
    info.set_organization("Leibniz Institute for Natural Product Research and Infection Biology - Hans Knöll Institute (HKI), Jena, Germany");
    info.set_url("https://applied-systems-biology.github.io/misa-framework/");

    info.add_dependency(misaxx::module_info());
    info.add_dependency(misaxx::ome::module_info());

    return info;
}
