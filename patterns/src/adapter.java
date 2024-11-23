interface USB {
    void connectWithUsbCable();
}

class MemoryCard {
    public void readData() {
        System.out.println("Чтение данных с карты памяти");
    }
}

class CardReaderAdapter implements USB {
    private MemoryCard memoryCard;

    public CardReaderAdapter(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        memoryCard.readData();
    }
}

class Computer {
    public void readDataFromUSB(USB usbDevice) {
        usbDevice.connectWithUsbCable();
    }

    public static void main(String[] args) {
        MemoryCard memoryCard = new MemoryCard();
        USB cardReaderAdapter = new CardReaderAdapter(memoryCard);

        Computer computer = new Computer();
        computer.readDataFromUSB(cardReaderAdapter);
    }
}