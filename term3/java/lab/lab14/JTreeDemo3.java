package lab14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class JTreeDemo3 implements ActionListener,TreeModelListener
{
    JLabel label = null;
    JTree tree = null;
    DefaultTreeModel treeModel = null;
    String nodeName = null; //ԭ�нڵ����� 
    
    public JTreeDemo3()
    {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
        tree = new JTree(root);
        tree.setEditable(true);
        tree.addMouseListener(new MouseHandle());
        treeModel = (DefaultTreeModel)tree.getModel();
        treeModel.addTreeModelListener(this);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tree);
        
        JPanel panel = new JPanel();
        JButton b = new JButton("�����ڵ�");
        b.addActionListener(this);
        panel.add(b);
        b = new JButton("ɾ���ڵ�");
        b.addActionListener(this);
        panel.add(b);
        b = new JButton("��������ڵ�");
        b.addActionListener(this);
        panel.add(b);
                
        label = new JLabel("Action");
        contentPane.add(panel,BorderLayout.NORTH);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        contentPane.add(label,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getActionCommand().equals("�����ڵ�"))
        {
            DefaultMutableTreeNode parentNode = null;
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
            newNode.setAllowsChildren(true);
            TreePath parentPath = tree.getSelectionPath();
            parentNode = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
            treeModel.insertNodeInto(newNode,parentNode,parentNode.getChildCount());
            tree.scrollPathToVisible(new TreePath(newNode.getPath()));
            label.setText("�����ڵ�ɹ�");
        }
        
        if (ae.getActionCommand().equals("ɾ���ڵ�"))
        {
            TreePath treepath = tree.getSelectionPath();
            if (treepath != null)
            {
                DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode)
                             treepath.getLastPathComponent();
                TreeNode parent = (TreeNode)selectionNode.getParent();
                if (parent != null)
                {
                    treeModel.removeNodeFromParent(selectionNode);
                    treeModel.reload();
                    label.setText("ɾ���ڵ�ɹ�");
                }
            }
        }
        
        if (ae.getActionCommand().equals("������нڵ�"))
        {
            DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)treeModel.getRoot();
            rootNode.removeAllChildren();
            treeModel.reload();
            label.setText("������нڵ�ɹ�");
        }
    }
    
    public void treeNodesChanged(TreeModelEvent e) {
          TreePath treePath = e.getTreePath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)treePath.getLastPathComponent();
        try {
            int[] index = e.getChildIndices();
            node = (DefaultMutableTreeNode)node.getChildAt(index[0]);
        } catch (NullPointerException exc) {}
        label.setText(nodeName+" ��������Ϊ: "+(String)node.getUserObject());
    }
    public void treeNodesInserted(TreeModelEvent e) {
        System.out.println("new node inserted");
    }
    public void treeNodesRemoved(TreeModelEvent e) {
        System.out.println("node deleted");
    }
    public void treeStructureChanged(TreeModelEvent e) {
        System.out.println("structrue changed");
    }

    public static void main(String args[]) {
            new JTreeDemo3();
    }
    
    class MouseHandle extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) 
        {
            try{
                JTree tree = (JTree)e.getSource();
                int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
                TreePath treepath = tree.getPathForRow(rowLocation);
                TreeNode treenode = (TreeNode) treepath.getLastPathComponent(); 
                nodeName = treenode.toString();
            }catch(NullPointerException ne){}
        }
    }
}
