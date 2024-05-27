package GUI.ForTraCuuDanhPhap.KhungHienThiTCDP;

import javax.swing.JPanel;

import Client.MainClient.MainClient;
import GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi.PaneMenuLuaChonMucDanhPhap;
import GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi.PanelChiTietMucDanhPhap;
import Model.ElementDanhPhapHoaHoc;
import Model.ElementMucDanhPhap;
import component.Notifications;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaneTraCuuDanhPhap extends JPanel {
	public PaneMenuLuaChonMucDanhPhap menuDP;
	public PanelChiTietMucDanhPhap chitiet;
	private JPanel paneMainTraCuu;
//	private boolean k = true;
	private JLabel lbBack;
	private MainClient client;
	private JFrame j;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws ClassNotFoundException
	 */
	public PaneTraCuuDanhPhap(MainClient client, JFrame j)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException {
		this.client = client;
		this.j = j;
		setBackground(new Color(64, 0, 128));
		setLayout(null);
		setBounds(0, 0, 1285, 635);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1285, 49);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRA C\u1EE8U DANH PH\u00C1P H\u00D3A H\u1ECCC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(471, -3, 343, 51);
		panel.add(lblNewLabel);

		BufferedImage myIconBack = ImageIO.read(new File("asset//img//back.png"));
		Image imgIconBack = myIconBack.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesBack = new ImageIcon(imgIconBack);
		lbBack = new JLabel(scalesBack);
		lbBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					chuyen(false, "a");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbBack.setBounds(10, 2, 40, 44);
		lbBack.setVisible(false);
		panel.add(lbBack);

		paneMainTraCuu = new JPanel();
		paneMainTraCuu.setBounds(0, 57, 1285, 578);
		paneMainTraCuu.setLayout(null);

		chuyen(false, "a");

	}

	public JPanel getSwitch() {
		return menuDP.getSwitch();
	}

	private void chuyen(boolean c, String code) throws MalformedURLException, UnsupportedAudioFileException,
			IOException, LineUnavailableException, ClassNotFoundException {
		if (!c) {

			menuDP = new PaneMenuLuaChonMucDanhPhap();
			menuDP.ion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "ion");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.salt.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.base.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.ocid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "oxide");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.ocid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "oxide");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.acid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.acid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.akan.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.anken.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.ankin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.hc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.halogen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.ancol.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.phenol.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.andehit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.keton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menuDP.ca.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						chuyen(true, "code");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			remove(paneMainTraCuu);
			paneMainTraCuu = menuDP;
			paneMainTraCuu.setBounds(0, 54, 1285, 578);
			add(paneMainTraCuu);
			revalidate();
			repaint();
			lbBack.setVisible(false);

		} else {
			client.dataOutput.writeUTF("DANHPHAP");
			client.dataOutput.writeUTF("GETDP");
			client.dataOutput.writeUTF(code);
			String s = client.dataInput.readUTF();
			if (s.equals("DONE")) {
				ElementMucDanhPhap eMDP = (ElementMucDanhPhap) client.objectInput.readObject();
				ArrayList<ElementDanhPhapHoaHoc> listDP = (ArrayList<ElementDanhPhapHoaHoc>) client.objectInput
						.readObject();
				chitiet = new PanelChiTietMucDanhPhap(eMDP, listDP);
				remove(paneMainTraCuu);
				paneMainTraCuu = chitiet;
				paneMainTraCuu.setBounds(0, 54, 1285, 578);
				add(paneMainTraCuu);
				revalidate();
				repaint();
				lbBack.setVisible(true);
				Notifications panel = new Notifications(j, Notifications.Type.SUCCESS,
						Notifications.Location.BOTTOM_CENTER, "lấy dữ liệu " + eMDP.getIdMucDanhPhap() + " thành công");
				panel.showNotification();
			} else {
				Notifications panel = new Notifications(j, Notifications.Type.WARNING,
						Notifications.Location.BOTTOM_CENTER, "Dữ liệu " + code + " chưa được cập nhật");
				panel.showNotification();
			}

		}
	}

}
