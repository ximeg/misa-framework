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

#include <misaxx-microbench/module.h>
#include <misaxx-microbench/module_info.h>
#include <misaxx/core/runtime/misa_cli.h>

using namespace misaxx;
using namespace misaxx_microbench;

int main(int argc, const char** argv) {
    misa_cli cli {};
    cli.set_module_info(misaxx_microbench::module_info());
    cli.set_root_module<misaxx_microbench::module>("misaxx-microbench");
    return cli.prepare_and_run(argc, argv);
}
