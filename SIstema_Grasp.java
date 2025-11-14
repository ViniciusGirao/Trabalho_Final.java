// Controla a criação e manipulação do pedido – centraliza a lógica para facilitar a organização do código
class OrderController {
    private Order currentOrder;

    public void startNewOrder() {
        currentOrder = new Order();
    }

    // Adiciona um produto ao pedido atual, criando um pedido novo se necessário
    public void addProductToOrder(String productName, int quantity) {
        if (currentOrder == null) {
            startNewOrder();
        }
        currentOrder.addItem(productName, quantity);
    }

    // Mostra os produtos do pedido ou mensagem caso esteja vazio
    public void showOrderSummary() {
        if (currentOrder == null || currentOrder.getItems().isEmpty()) {
            System.out.println("Pedido vazio.");
            return;
        }
        System.out.println("Resumo do pedido:");
        for (OrderItem item : currentOrder.getItems()) {
            System.out.printf("- %s: %d unidades%n", item.getProductName(), item.getQuantity());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OrderController controller = new OrderController();

        // Usamos o controlador para gerenciar o pedido e itens
        controller.addProductToOrder("Teclado", 2);
        controller.addProductToOrder("Mouse", 1);

        // Exibe o resumo do pedido feito
        controller.showOrderSummary();
    }
}
