package br.com.felipecostadev.prototype.manager.client;

import br.com.felipecostadev.prototype.client.Client;
import br.com.felipecostadev.prototype.client.mode.ClientMode;

import java.util.*;

public class ClientManager {

    private Map<UUID, Client> clientMap;

    public ClientManager() {
        this.clientMap = new HashMap<>();
    }

    public Client get(UUID uniqueId) {
        return clientMap.get(uniqueId);
    }

    public Collection<Client> getCollection() {
        return clientMap.values();
    }

    public List<Client> getModeList(ClientMode clientMode) {
        List<Client> clientList = new ArrayList<>();

        getCollection().stream()
                .filter(client -> client.hasMode(clientMode))
                .forEach(client -> clientList.add(client));

        return clientList;
    }

    public void put(Client client) {
        clientMap.put(client.getPlayer().getUniqueId(), client);
    }

    public void remove(UUID uniqueId) {
        clientMap.remove(uniqueId);
    }
}