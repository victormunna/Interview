/**
 * The MIT License Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package designpattern.behavioral.iterator;

import designpattern.behavioral.iterator.bst.BstIterator;
import designpattern.behavioral.iterator.bst.TreeNode;
import designpattern.behavioral.iterator.list.Item;
import designpattern.behavioral.iterator.list.ItemType;
import designpattern.behavioral.iterator.list.TreasureChest;

import static designpattern.behavioral.iterator.list.ItemType.*;


/**
 * The Iterator pattern is a design pattern in which an iterator is used to traverse a container and
 * access the container's elements. The Iterator pattern decouples algorithms from containers.
 * <p>
 * In this example the Iterator ({@link Iterator}) adds abstraction layer on top of a collection
 * ({@link TreasureChest}). This way the collection can change its internal implementation without
 * affecting its clients.
 */
public class App {

    private static final TreasureChest TREASURE_CHEST = new TreasureChest();

    private static void demonstrateTreasureChestIteratorForType(ItemType itemType) {
        System.out.println("------------------------");
        System.out.println("Item Iterator for ItemType " + itemType + ": ");
        Iterator<Item> itemIterator = TREASURE_CHEST.iterator(itemType);
        while (itemIterator.hasNext()) {
            System.out.println(itemIterator.next().toString());
        }
    }

    private static void demonstrateBstIterator() {
        System.out.println("------------------------");
        System.out.println("BST Iterator: ");
        TreeNode<Integer> root = buildIntegerBst();
        BstIterator bstIterator = new BstIterator<>(root);
        while (bstIterator.hasNext()) {
            System.out.println("Next node: " + bstIterator.next().getVal());
        }
    }

    private static TreeNode<Integer> buildIntegerBst() {
        TreeNode<Integer> root = new TreeNode<>(8);

        root.insert(3);
        root.insert(10);
        root.insert(1);
        root.insert(6);
        root.insert(14);
        root.insert(4);
        root.insert(7);
        root.insert(13);

        return root;
    }

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        demonstrateTreasureChestIteratorForType(RING);
        demonstrateTreasureChestIteratorForType(POTION);
        demonstrateTreasureChestIteratorForType(WEAPON);
        demonstrateTreasureChestIteratorForType(ANY);

        demonstrateBstIterator();
    }
}
