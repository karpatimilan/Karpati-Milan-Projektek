#pragma once

namespace WindowsForm {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Summary for Form1
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
		Form1(void)
		{
			InitializeComponent();
			//
			//TODO: Add the constructor code here
			//
		}

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Timer^ timer1;
	protected:
	private: System::IO::Ports::SerialPort^ serialPort1;
	private: System::Windows::Forms::Button^ button1;
	private: System::Windows::Forms::ComboBox^ comboBox1;
	private: System::Windows::Forms::ListBox^ listBox1;
	private: System::Windows::Forms::Button^ button2;
	private: System::Windows::Forms::Button^ button3;
	private: System::Windows::Forms::Button^ button4;
	private: System::Windows::Forms::GroupBox^ groupBox1;
	private: System::Windows::Forms::Button^ button5;

	private: System::Windows::Forms::Label^ label1;

	private: System::Windows::Forms::GroupBox^ groupBox2;
	private: System::Windows::Forms::Label^ label2;

	private: System::ComponentModel::IContainer^ components;

	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>


#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			this->components = (gcnew System::ComponentModel::Container());
			this->timer1 = (gcnew System::Windows::Forms::Timer(this->components));
			this->serialPort1 = (gcnew System::IO::Ports::SerialPort(this->components));
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->comboBox1 = (gcnew System::Windows::Forms::ComboBox());
			this->listBox1 = (gcnew System::Windows::Forms::ListBox());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->groupBox1 = (gcnew System::Windows::Forms::GroupBox());
			this->groupBox2 = (gcnew System::Windows::Forms::GroupBox());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->groupBox1->SuspendLayout();
			this->groupBox2->SuspendLayout();
			this->SuspendLayout();
			// 
			// timer1
			// 
			this->timer1->Tick += gcnew System::EventHandler(this, &Form1::timer1_Tick);
			// 
			// serialPort1
			// 
			this->serialPort1->PortName = L"COM6";
			this->serialPort1->DataReceived += gcnew System::IO::Ports::SerialDataReceivedEventHandler(this, &Form1::serialPort1_DataReceived);
			// 
			// button1
			// 
			this->button1->BackColor = System::Drawing::Color::PaleGreen;
			this->button1->Location = System::Drawing::Point(-3, 4);
			this->button1->Margin = System::Windows::Forms::Padding(2);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(165, 41);
			this->button1->TabIndex = 0;
			this->button1->Text = L"button1";
			this->button1->UseVisualStyleBackColor = false;
			this->button1->Click += gcnew System::EventHandler(this, &Form1::button1_Click);
			// 
			// comboBox1
			// 
			this->comboBox1->BackColor = System::Drawing::Color::White;
			this->comboBox1->FormattingEnabled = true;
			this->comboBox1->Location = System::Drawing::Point(346, 162);
			this->comboBox1->Margin = System::Windows::Forms::Padding(2);
			this->comboBox1->Name = L"comboBox1";
			this->comboBox1->Size = System::Drawing::Size(102, 21);
			this->comboBox1->TabIndex = 1;
			// 
			// listBox1
			// 
			this->listBox1->FormattingEnabled = true;
			this->listBox1->Location = System::Drawing::Point(11, 141);
			this->listBox1->Margin = System::Windows::Forms::Padding(2);
			this->listBox1->Name = L"listBox1";
			this->listBox1->Size = System::Drawing::Size(331, 186);
			this->listBox1->TabIndex = 2;
			// 
			// button2
			// 
			this->button2->BackColor = System::Drawing::Color::FromArgb(static_cast<System::Int32>(static_cast<System::Byte>(255)), static_cast<System::Int32>(static_cast<System::Byte>(128)),
				static_cast<System::Int32>(static_cast<System::Byte>(128)));
			this->button2->Location = System::Drawing::Point(163, 0);
			this->button2->Margin = System::Windows::Forms::Padding(2);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(165, 41);
			this->button2->TabIndex = 3;
			this->button2->Text = L"button2";
			this->button2->UseVisualStyleBackColor = false;
			this->button2->Click += gcnew System::EventHandler(this, &Form1::button2_Click);
			// 
			// button3
			// 
			this->button3->BackColor = System::Drawing::Color::Yellow;
			this->button3->Location = System::Drawing::Point(-1, 0);
			this->button3->Margin = System::Windows::Forms::Padding(2);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(165, 41);
			this->button3->TabIndex = 4;
			this->button3->Text = L"button3";
			this->button3->UseVisualStyleBackColor = false;
			this->button3->Click += gcnew System::EventHandler(this, &Form1::button3_Click);
			// 
			// button4
			// 
			this->button4->BackColor = System::Drawing::Color::Silver;
			this->button4->Location = System::Drawing::Point(162, 4);
			this->button4->Margin = System::Windows::Forms::Padding(2);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(169, 41);
			this->button4->TabIndex = 5;
			this->button4->Text = L"button4";
			this->button4->UseVisualStyleBackColor = false;
			this->button4->Click += gcnew System::EventHandler(this, &Form1::button4_Click);
			// 
			// groupBox1
			// 
			this->groupBox1->Controls->Add(this->button1);
			this->groupBox1->Controls->Add(this->button4);
			this->groupBox1->Location = System::Drawing::Point(11, 98);
			this->groupBox1->Margin = System::Windows::Forms::Padding(2);
			this->groupBox1->Name = L"groupBox1";
			this->groupBox1->Padding = System::Windows::Forms::Padding(2);
			this->groupBox1->Size = System::Drawing::Size(331, 43);
			this->groupBox1->TabIndex = 6;
			this->groupBox1->TabStop = false;
			// 
			// groupBox2
			// 
			this->groupBox2->Controls->Add(this->button3);
			this->groupBox2->Controls->Add(this->button2);
			this->groupBox2->Location = System::Drawing::Point(11, 95);
			this->groupBox2->Name = L"groupBox2";
			this->groupBox2->Size = System::Drawing::Size(328, 41);
			this->groupBox2->TabIndex = 9;
			this->groupBox2->TabStop = false;
			// 
			// button5
			// 
			this->button5->BackColor = System::Drawing::Color::White;
			this->button5->Location = System::Drawing::Point(346, 187);
			this->button5->Margin = System::Windows::Forms::Padding(2);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(100, 26);
			this->button5->TabIndex = 7;
			this->button5->Text = L"button5";
			this->button5->UseVisualStyleBackColor = false;
			this->button5->Click += gcnew System::EventHandler(this, &Form1::button5_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(346, 215);
			this->label1->Margin = System::Windows::Forms::Padding(2, 0, 2, 0);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(41, 15);
			this->label1->TabIndex = 8;
			this->label1->Text = L"label1";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 48, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(238)));
			this->label2->Location = System::Drawing::Point(60, 5);
			this->label2->Margin = System::Windows::Forms::Padding(2, 0, 2, 0);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(249, 91);
			this->label2->TabIndex = 10;
			this->label2->Text = L"label2";
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(457, 334);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->groupBox2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->groupBox1);
			this->Controls->Add(this->listBox1);
			this->Controls->Add(this->comboBox1);
			this->Name = L"Form1";
			this->Text = L"Form1 - MOGI template";
			this->Load += gcnew System::EventHandler(this, &Form1::Form1_Load);
			this->groupBox1->ResumeLayout(false);
			this->groupBox2->ResumeLayout(false);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	
	//segédváltozó
		int i = 1;

		//felület elemek neveinek és láthatóságának beállítása
	private: System::Void Form1_Load(System::Object^ sender, System::EventArgs^ e) {
		Text = "Stopper";
		button1->Text = "Start";
		button2->Text = "Leállítás";
		button3->Text = "Kör";
		button4->Text = "Törlés";
		button5->Text = "Csatlakozás";
		label1->Text = "Eszköz kiválasztása";
		label2->Text = "00:00";
		
		groupBox1->Enabled = true;
		groupBox2->Visible = false;
		groupBox2->Enabled = false;
		
		timer1->Interval = 100;
		
		array<String^>^ portok = System::IO::Ports::SerialPort::GetPortNames();
		comboBox1->Items->AddRange(portok);
		
	}
//A 1-es gomb megnyomására a mikrovezérlõnek küldünk egy S betût amely elindítja a stoppert
//Emellett az adott állapotokban releváns gombokat megjeleníti,illetve az irrelevánsakat
//eltûntei
private: System::Void button1_Click(System::Object^ sender, System::EventArgs^ e) {

	try {
	
	
		serialPort1->WriteLine("S");
		groupBox2->Visible = true;
		groupBox2->Enabled = true;
		groupBox1->Visible = false;
		groupBox1->Enabled = false;
		

	}
	catch (Exception^ ex) {

	}


}
//A 2-es gomb megnyomására a mikrovezérlõnek küldünk egy M betût amely megállítja a stoppert
private: System::Void button2_Click(System::Object^ sender, System::EventArgs^ e) {
	try {
	
		serialPort1->WriteLine("M");
		groupBox2->Visible = false;
		groupBox2->Enabled = false;
		groupBox1->Visible = true;
		groupBox1->Enabled = true;
		

	}
	catch (Exception^ ex) {

	}
	
}
	   //A 4-es gomb megnyomására a mikrovezérlõnek küldünk egy R betût amely nullázza a stoppert
private: System::Void button4_Click(System::Object^ sender, System::EventArgs^ e) {

	try {

		serialPort1->WriteLine("R");
		groupBox2->Visible = false;
		groupBox2->Enabled = false;
		groupBox1->Visible = true;
		groupBox1->Enabled = true;
		listBox1->Items->Clear();
		i = 1;
	}
	catch (Exception^ ex) {

	}

}
	   // A gomb megnyomására a számítógép csatlakozik a mikrovezrélõhöz és beállítjuk a kommunikációs paramétereket
private: System::Void button5_Click(System::Object^ sender, System::EventArgs^ e) {
	try {
		serialPort1->PortName = comboBox1->Text;
		serialPort1->BaudRate = 11500;
		serialPort1->NewLine = "\r\n";
		serialPort1->Open();
		groupBox1->Enabled = true;
		groupBox1->Visible = true;
		timer1->Start();

	}
	catch (Exception^ ex) {

	}
}
	   // Minden timer cikus esetében a számítógép küld egy kérdõjelet a mikrovezérlõnek amely lekérdezi
	   //a stopperen látható aktuális idõt, illetve azt vizsgálja,hogy a köridõ gomb le lett e nyomva
	private: System::Void timer1_Tick(System::Object^ sender, System::EventArgs^ e) {

		if (serialPort1->IsOpen) {
			

			serialPort1->WriteLine("?");
			String^ ido = serialPort1->ReadLine();

			

			if (ido == "k") {
				System::Threading::Thread::Sleep(100);
				serialPort1->WriteLine("?");
				

				ido = serialPort1->ReadLine();
				if (ido != "k") {
					listBox1->Items->Add(Convert::ToString(i) + ".kör: " + ido);
					i++;
				}
			}
			else {
				System::Threading::Thread::Sleep(20);
				label2->Text = ido;
			}

			
			

		}
	}
//A 3-as gomb megnyomására a mikrovezérlõnek küldünk egy ? jelet amely lekérdezi a köridõt, majd frissítjük a
//köridõk listáját
private: System::Void button3_Click(System::Object^ sender, System::EventArgs^ e) {
	if (serialPort1->IsOpen) {
		
		serialPort1->WriteLine("?");
		System::Threading::Thread::Sleep(100);
		String^ tmp = serialPort1->ReadLine();
		listBox1->Items->Add(Convert::ToString(i)+".kör: "+tmp);
		i++;
	}
	
}
private: System::Void serialPort1_DataReceived(System::Object^ sender, System::IO::Ports::SerialDataReceivedEventArgs^ e) {

}




private: System::Void label2_Click(System::Object^ sender, System::EventArgs^ e) {
}
};
}
