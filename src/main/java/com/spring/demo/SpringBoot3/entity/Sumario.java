package com.spring.demo.SpringBoot3.entity;

/**Classe do tipo Sumario, vai fazer total de sumário do meu tipo de movimentação.
* @author Josue Silva Rosa
* @version java 11
*/

public class Sumario {
    private long totalImportacao;
    private long totalExportacao;

    public long getTotalImportacao() {
        return totalImportacao;
    }

    public void setTotalImportacao(long totalImportacao) {
        this.totalImportacao = totalImportacao;
    }

    public long getTotalExportacao() {
        return totalExportacao;
    }

    public void setTotalExportacao(long totalExportacao) {
        this.totalExportacao = totalExportacao;
    }
}
