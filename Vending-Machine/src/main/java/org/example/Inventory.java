package org.example;

public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();

    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory(){
        int startCode = 101;
        for(int i=0;i<inventory.length;i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);  /// need to know why not false initially....
            inventory[i] = space;
            startCode++;
        }
    }

    public void additem(Item item, int codeNumber) throws Exception {

        for(ItemShelf itemShelf: inventory){
            if(itemShelf.code == codeNumber){
                if(itemShelf.isSoldOut()){
                    // item is being sold-out we need to add inventory for that item basically..
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                }
                else {
                    throw new Exception("Item is already present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {

        for(ItemShelf itemShelf: inventory){
            if(itemShelf.code == codeNumber){
                if(itemShelf.isSoldOut()){
                    throw new Exception("Item is already sold out");
                }
                else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf:inventory){
            if(itemShelf.code == codeNumber){
                itemShelf.setSoldOut(true);
            }
        }
    }

}
