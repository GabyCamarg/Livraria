package service;

import dao.PedidoDAO;

public class ProcessadorPedidos extends Thread {

    private PedidoDAO pedidoDAO = new PedidoDAO();
    private boolean executando = true;

    public void encerrar() {
        executando = false;
    }

    @Override
    public void run() {

        while(executando) {

            try {

                Integer idPedido = pedidoDAO.buscarPedidoNaFila();

                if(idPedido != null) {

                    System.out.println("Processando pedido " + idPedido);

                    pedidoDAO.atualizarStatus(idPedido, "PROCESSANDO");

                    Thread.sleep(3000);

                    pedidoDAO.atualizarStatus(idPedido, "FINALIZADO");

                    System.out.println("Pedido " + idPedido + " finalizado.");

                }

                Thread.sleep(2000);

            } catch(Exception e) {

                System.out.println("Erro na thread: " + e.getMessage());

            }
        }
    }
}